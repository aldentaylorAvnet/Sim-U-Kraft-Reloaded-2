package ashjack.SUKReloaded2.core.util;

import java.io.Serializable;

public class V3 implements Serializable, Cloneable
{
	private static final long serialVersionUID = 3681796724829797704L;
	public Double x;
	public Double y;
	public Double z;
	public String name = "";
	public int blockID = 0;
	public int meta = 0;  //currently used for building's special blocks (in cheese factory, burger store)
	public int theDimension = 0;
	public Double destinationAcc=1.5d;
	public boolean doNotTimeout = false;

	public V3()
	{
	}

	@Override
	public V3 clone()
	{
		V3 retV = new V3(this.x, this.y, this.z, this.theDimension);
		return retV;
	}

	/*
    public V3(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
	 */

	/** overload to include the dimension 0=overworld, -1=nether 1=end  2 onwards could be Mystcraft ages */
	public V3(Double x, Double y, Double z, int dimension)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.theDimension = dimension;
	}

	public V3(int x, int y, int z, int dimension) {
		this.x = (double) x;
		this.y = (double) y;
		this.z = (double) z;
		this.theDimension = dimension;
	}

	/** overload for loading text-based saved files in as a V3 */
	public V3(String v3) {
		String[]v=v3.split(",");
		this.x=Double.parseDouble(v[0]);
		this.y=Double.parseDouble(v[1]);
		this.z=Double.parseDouble(v[2]);
		this.theDimension=Integer.parseInt(v[3]);
	}

	// Used any more?
	public V3(Double x, Double y, Double z, int id, int meta)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockID = id;
		this.meta = meta;
	}

	public V3(int i, int j, int k)
	{
		this.x = (double) i;
		this.y = (double) j;
		this.z = (double) k;
	}

	public void setVals(V3 v)
	{
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}

	/** compares the x y and z to see if they are the same and only INT values, not double Also compares dimension */
	public boolean isSameCoordsAs(V3 comp, boolean compareDimension, boolean exactly)
	{
		boolean ret = false;

		if (comp == null)
		{
			return false;
		}

		if (exactly)
		{
			if (this.getDistanceTo(comp) == 0 && (this.theDimension == comp.theDimension || !compareDimension))
			{
				ret = true;
			}
		}
		else
		{
			if (this.getDistanceTo(comp) <= 2 && (this.theDimension == comp.theDimension || !compareDimension))
			{
				ret = true;
			}
		}

		return ret;
	}

	/** works out and return distance between this V3 and the passed in V3 - assumes same dimension*/
	public int getDistanceTo(V3 other)
	{
		if (other == null)
		{
			return 0;
		}

		double dist = Math.sqrt((other.x - this.x) * (other.x - this.x) +
				(other.y - this.y) * (other.y - this.y) +
				(other.z - this.z) * (other.z - this.z));
		return (int)dist;
	}

	@Override
	public String toString()
	{
		return x.intValue() + "," + y.intValue() + "," + z.intValue()+","+theDimension;
	}
}
