package pl.silver.files;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import jcifs.util.LogStream;

public class CifsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String user = "Radek" + ":" + "RDP@Cargos1234";
		
		jcifs.Config.setProperty( "jcifs.netbios.wins", "94.23.1.64" );
		
		jcifs.Config.setProperty("jcifs.resolveOrder", "LMHOSTS,WINS,DNS,BCAST"); 
		jcifs.Config.setProperty("jcifs.encoding", "Latin1"); 
		jcifs.Config.setProperty("jcifs.smb.client.dfs.disabled", "true"); 
		jcifs.Config.setProperty("jcifs.smb.client.useExtendedSecurity", "false"); 
		jcifs.Config.setProperty("jcifs.util.loglevel", "3"); 
		jcifs.Config.setProperty("jcifs.smb.lmCompatibility", "2"); 
		
		
		LogStream.setLevel(10);
		NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication(null, "Radek", "RDP@Cargos1234"); // domain,
		try {

			// String sharedFolder = "DavWWWRoot";
			// String path = "smb://ns364990.ovh.net:5589/" + sharedFolder +
			// "/test.txt";
			// SmbFile smbFile = new SmbFile(path, authentication);
			// SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile);
			// smbfos.write("testing....and writing to a file".getBytes());
			// System.out.println("completed ...nice !");

//			SmbFile currentFolder = new SmbFile("smb://94.23.1.64:5589/DavWWWRoot/", authentication);
			
				SmbFile currentFolder = new SmbFile("http://Radek@ns364990.ovh.net:5589/shared");
			SmbFile[] listFiles = currentFolder.listFiles();
			for (SmbFile file : listFiles) {
				System.out.println(file);
			}
		} catch (SmbException e) {
			e.printStackTrace();
			fail("Error");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("Z³e dane");
		} catch (IOException e) {
			e.printStackTrace();
			fail("Error");
		}
	}

}
