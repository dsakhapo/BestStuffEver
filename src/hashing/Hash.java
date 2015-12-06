package hashing;
import java.math.BigInteger;
import java.math.BigDecimal;

public class Hash 
{
	private HashEntry[] table;
	private int binaryArraySize;
	
	public Hash(int binaryArraySize)
	{
		table = new HashEntry[1024];
		this.binaryArraySize = binaryArraySize;
	}
	
	public int hash(BigInteger userId, BigInteger salt)
	{
		BigInteger hashFunction;
		int hashValue = 0;
		
		for(int i = 0; i < table.length; ++i)
			table[i] = null;
		
		BigDecimal modValue = BigDecimal.valueOf(Math.pow(2, binaryArraySize));
		BigDecimal denominator = BigDecimal.valueOf(Math.pow(2, binaryArraySize) / Math.pow(2, 10));
		BigInteger mValue = modValue.toBigInteger();
		BigInteger denom = denominator.toBigInteger();
		
		hashFunction = (((salt.multiply(userId)).mod(mValue)).divide(denom));
		hashValue = hashFunction.intValue();
		
		return hashValue;
	}
}
