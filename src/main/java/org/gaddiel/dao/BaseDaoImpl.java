package org.gaddiel.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl {
	
	public ByteArrayInputStream saveBLOB(List paginationList) throws IOException
	{
	
	ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
	ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
	objectoutputstream.writeObject(paginationList);//writing an object
	byte abyte[] = bytearrayoutputstream.toByteArray();
	ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte);
	return bytearrayinputstream;

	
	}

}
