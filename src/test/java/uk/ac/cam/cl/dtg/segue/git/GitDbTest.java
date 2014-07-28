package uk.ac.cam.cl.dtg.segue.git;

import org.eclipse.jgit.api.Git;
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
}
