package pl.silver.files.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SimpleOperations {
	public static void move(String source, String target) throws IOException {
		Path sourcePath = new File(source).toPath();
		Path targetPath = new File(target).toPath();
		Files.move(sourcePath, targetPath, StandardCopyOption.ATOMIC_MOVE);
	}

	public static void copy(String source, String target) throws IOException {
		Path sourcePath = new File(source).toPath();
		Path targetPath = new File(target).toPath();
		Files.copy(sourcePath, targetPath, StandardCopyOption.ATOMIC_MOVE);
	}
}
