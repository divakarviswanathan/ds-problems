package edu.diva.ds.graph;

import java.util.Arrays;
import java.util.List;

public class FilePathTest {

	public static void main(String[] a) {
		String[] paths = { "D:\\Documents\\Scanned", "D:\\Documents\\Scanned\\Passport",
				"D:\\Documents\\Scanned\\PAN.png", "D:\\Documents\\Scanned\\DL.png",
				"D:\\Documents\\Scanned\\Passport\\Front.png", "D:\\Documents\\Scanned\\Passport\\Back.png",
				"D:\\Documents\\Screenshot.png" };
		FilePathTest fp = new FilePathTest();
		fp.GetRootFolder(Arrays.asList(paths));
	}

	Object GetRootFolder(List<String> filePaths) {
		Tree t = new Tree(new Node("", ""));
		for (String str : filePaths) {
			t.addElement(str);
		}

		t.printTree();
		return t;
	}
}
