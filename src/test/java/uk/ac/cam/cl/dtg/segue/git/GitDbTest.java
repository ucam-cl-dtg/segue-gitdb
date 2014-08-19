package uk.ac.cam.cl.dtg.segue.git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class GitDbTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void connectToLocal() throws Exception {
		Git.init().setDirectory(folder.getRoot()).call();
		new GitDb(folder.getRoot().getAbsolutePath());
	}

	@Test
	public void cloneRemote() throws IOException, InvalidRemoteException, TransportException, GitAPIException {
		String[] privateKey = new String[] {
				"-----BEGIN DSA PRIVATE KEY-----", //
				"MIIBvAIBAAKBgQDpPLa6DQgSfaJLvkfo97MYgLuDIGhk2IL/XATlSSscX79p0V82", //
				"ybbeccq13sc9duDV9T+MgUcaYP7WzTEWWFxddikSuTGygB/8nVeDe0pmiEYRNDfg", //
				"CfVdNutqaKhMIFP2wjPJh8EwNvA4E2nnbuoWTqCz0nV4L+c6depAb0/dLwIVAL23", //
				"IYq1L6/sFw1BpbOPf6W3tjOjAoGBAOYjKXpHd/H0RWpHX/WZ6KXGBm9qobskHWs1", //
				"61HtHRabueFd9ekH45NMgqQmA2evY2hlPnUWynC8Ln+/C8vp194AkwTy1u3U8lJw", //
				"EaF8VyVCMRxEprj66Y0TT/MKjiVp2RMJ7Zx1Zl8v9FmeQUhi/gPAovdef0hjYu2D", //
				"d6IbFvsBAoGAUDmgVdL6fAkSG06OtEEKGTl0//DfK/Ohr7ll1ygOwu8Ay3FwO/wL", //
				"4V+Lw+NCskN5XkQ/bWPv/k6A81w3Bbvol+9enDM+cPejDzxkXNlZloezw/AfGFAS", //
				"8yfVxRCLHCJF9zltYqV0vrMVp1fAlWvpDq+dyts0U6fMG0v3sE5yDUUCFQC3jD3S", //
				"+1AATzeUEVkbPSZP3fqYcw==", //
				"-----END DSA PRIVATE KEY-----" };

		File keyFile = folder.newFile();
		try (PrintWriter w = new PrintWriter(new FileWriter(keyFile))) {
			for(String s : privateKey) {
				w.println(s);
			}
		}

		File repoFolder = folder.newFolder();		
		new GitDb("git@github.com:ucam-cl-dtg/segue-gitdb.git",repoFolder,false,"master","origin",keyFile.getAbsolutePath());
		Assert.assertTrue(new File(repoFolder,"README.md").exists());
	}
}
