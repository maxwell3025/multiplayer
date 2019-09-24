package BinaryInteractions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.DADD;

public class FileInput {
	public static void main(String[] args) throws IOException {
		int[] data = readints("C:/stuff.dat ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(',');
		}
	}

	public static int toint(byte[] i) { 
		int result =  Universalfunctions.totrue((int)i[0]) * 16777216 +  Universalfunctions.totrue((int)i[1]) * 65536 +  Universalfunctions.totrue((int)i[2]) * 256 +  Universalfunctions.totrue((int)i[3]);
		return result;
	}

	public static int[] readints(String fileName) throws IOException {
		FileInputStream input = new FileInputStream(fileName);
		int count = -1;
		List<Byte> l = new ArrayList<Byte>();
		while (!l.contains((byte) -1)) {
			l.add((byte) input.read());
			count++;
		}
		input.close();
		List<Integer> d = new ArrayList<Integer>();
		for (int i = 0; i < count; i += 1) {
			//byte[] nums = { l.get(i), l.get(i + 1), l.get(i + 2), l.get(i + 3) };
			byte[] nums = { 0,0,0,l.get(i)};
			d.add(toint(nums));
		}
		int[] c = new int[d.size()];
		for (int i = 0; i < d.size(); i++) {
			c[i] = d.get(i);
		}

		return c;
	}
}
