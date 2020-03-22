package net.taglaviam.openvt.core.structural;

import java.io.File;
import java.util.List;
import java.util.Set;

public abstract class IspObjectReader {

    protected List<String> fileContentLines;
    protected Set<GenericIspObject> genericIspObjects;

    public abstract IspObjectReader withFileContentLines(final File file);

    public abstract IspObjectReader withGenericIspObjects(final Set<GenericIspObject> genericIspObjects);

    public abstract Set<GenericIspObject> withGenericIspObjects();

    public abstract IspObjectReader findGenericIspObjects();
}
