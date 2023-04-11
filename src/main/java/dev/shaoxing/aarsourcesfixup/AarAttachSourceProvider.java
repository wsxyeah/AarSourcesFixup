package dev.shaoxing.aarsourcesfixup;

import com.intellij.codeInsight.AttachSourcesProvider;
import com.intellij.openapi.roots.LibraryOrderEntry;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class AarAttachSourceProvider implements AttachSourcesProvider {
    private final GradleAttachSourcesProvider delegate = new GradleAttachSourcesProvider();

    @Override
    public @NotNull Collection<AttachSourcesAction> getActions(List<LibraryOrderEntry> orderEntries, PsiFile psiFile) {
        return delegate.getActions(orderEntries, psiFile);
    }
}
