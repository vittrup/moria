package net.ebondark.moria.felix.api;

import java.io.File;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nebulus
 * Date: 17-07-11
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
public interface FileUploadPlugin {
    public void uploaded(File file);

    public Set<String> extensions();
}
