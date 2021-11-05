package org.hl7.hapi;


import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import java.io.IOException;
import java.util.Collection;

/**
 * ‎
 * Bidi characters above
 */
public class App {
    final public static String REPO_URL = "https://github.com/hapifhir/actions-playground.git";

    public static void main( String[] args ) throws GitAPIException {
        System.out.println( "Hello World!" );

        Collection<Ref> refs = Git.lsRemoteRepository()
                .setHeads(true)
                .setRemote(REPO_URL)
                .call();

        for (Ref ref : refs) {
            String branchName = ref.getName().substring(ref.getName().lastIndexOf("/") + 1, ref.getName().length());
            System.out.println("Branch: " + branchName + " (" + ref.getObjectId().getName() + ")");
        }

        System.out.println();
    }
}
