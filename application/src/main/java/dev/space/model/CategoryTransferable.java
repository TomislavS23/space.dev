package dev.space.model;

import dev.space.dto.CategoryDTO;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.module.ModuleDescriptor;

/**
 *
 * @author tomislav
 */
public class CategoryTransferable implements Transferable {

    private CategoryDTO category;
    public static final DataFlavor CATEGORY_FLAVOR = new DataFlavor(CategoryDTO.class, "Category");
    private static final DataFlavor[] SUPPORTED_FLAVORS = { CATEGORY_FLAVOR };

    public CategoryTransferable(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return CATEGORY_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return category;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
