package ashjack.SUKReloaded2.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Packager
{
    public static void packZip(File output, List<File> sources) throws IOException
    {
        System.out.println("Packaging to " + output.getName());
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(output));
        zipOut.setLevel(Deflater.DEFAULT_COMPRESSION);

        for (File source : sources)
        {
            if (source.isDirectory())
            {
                zipDir(zipOut, "", source);
            } else
            {
                zipFile(zipOut, "", source);
            }
        }
        zipOut.flush();
        zipOut.close();
        System.out.println("Done");
    }

    private static String buildPath(String path, String file)
    {
        if (path == null || path.isEmpty())
        {
            return file;
        }
		return path + "/" + file;
    }

    private static void zipDir(ZipOutputStream zos, String path, File dir) throws IOException
    {
        if (!dir.canRead())
        {
            System.out.println("Cannot read " + dir.getCanonicalPath() + " (maybe because of permissions)");
            return;
        }

        File[] files = dir.listFiles();
        path = buildPath(path, dir.getName());
        System.out.println("Adding Directory " + path);

        for (File source : files)
        {
            if (source.isDirectory())
            {
                zipDir(zos, path, source);
            } else
            {
                zipFile(zos, path, source);
            }
        }

        System.out.println("Leaving Directory " + path);
    }

    private static void zipFile(ZipOutputStream zos, String path, File file) throws IOException
    {
        if (!file.canRead())
        {
            System.out.println("Cannot read " + file.getCanonicalPath() + " (maybe because of permissions)");
            return;
        }

        System.out.println("Compressing " + file.getName());
        zos.putNextEntry(new ZipEntry(buildPath(path, file.getName())));

        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[4092];
        int byteCount = 0;
        while ((byteCount = fis.read(buffer)) != -1)
        {
            zos.write(buffer, 0, byteCount);
            System.out.print('.');
            System.out.flush();
        }
        System.out.println();

        fis.close();
        zos.closeEntry();
    }
    
    public static void addFilesToExistingZip(File zipFile,
            File[] files) throws IOException {
           // get a temp file
       File tempFile = File.createTempFile(zipFile.getName(), null);
       tempFile.setWritable(true);
       zipFile.setReadable(true);
       zipFile.setWritable(true);
       zipFile.setExecutable(true);
           // delete it, otherwise you cannot rename your existing zip to it.
       tempFile.delete();

       boolean renameOk=zipFile.renameTo(tempFile);
       if (!renameOk)
       {
           throw new RuntimeException("could not rename the file "+zipFile.getAbsolutePath()+" to "+tempFile.getAbsolutePath());
       }
       byte[] buf = new byte[1024];

       ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
       ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));

       ZipEntry entry = zin.getNextEntry();
       while (entry != null) {
           String name = entry.getName();
           boolean notInFiles = true;
           for (File f : files) {
               if (f.getName().equals(name)) {
                   notInFiles = false;
                   break;
               }
           }
           if (notInFiles) {
               // Add ZIP entry to output stream.
               out.putNextEntry(new ZipEntry(name));
               // Transfer bytes from the ZIP file to the output file
               int len;
               while ((len = zin.read(buf)) > 0) {
                   out.write(buf, 0, len);
               }
           }
           entry = zin.getNextEntry();
       }
       // Close the streams        
       zin.close();
       // Compress the files
       for (int i = 0; i < files.length; i++) {
    	   files[i].setWritable(true);
           InputStream in = new FileInputStream(files[i]);
           // Add ZIP entry to output stream.
           out.putNextEntry(new ZipEntry(files[i].getName()));
           // Transfer bytes from the file to the ZIP file
           int len;
           while ((len = in.read(buf)) > 0) {
               out.write(buf, 0, len);
           }
           // Complete the entry
           out.closeEntry();
           in.close();
       }
       // Complete the ZIP file
       out.close();
       tempFile.delete();
   }
}