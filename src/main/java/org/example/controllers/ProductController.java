package org.example.controllers;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.example.models.Category;
import org.example.models.Product;
import org.example.models.enums.ProductEnum;

import java.util.*;
import java.util.stream.Collectors;

public class ProductController {

    private List<Product> productList = ProductEnum.getAllProducts();

    public Set<String> getDistinctLinesSorted() {
        return productList.stream()
                .map(Product::getLine)
                .filter(line -> !line.isEmpty())
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    public Set<Category> getCategoriesAndModelsForLine(String selectedLine) {
        Set<Category> productCategories = new HashSet<>();

        productList.stream()
                .filter(p -> p.getLine().equals(selectedLine))
                .forEach(lineProduct -> {
                    if (!lineProduct.getCategory().isEmpty() && !lineProduct.getModel().isEmpty()) {
                        productCategories.add(new Category(lineProduct.getCategory(), lineProduct.getModel()));
                    }
                });

        return productCategories;
    }

    public void loadTreeViewData(TreeView<String> treeView, Set<Category> productCategories) {

        TreeItem<String> rootItem = new TreeItem<>("Categorias e Modelos");
        rootItem.setExpanded(true);

        Map<String, List<Category>> categoryMap = productCategories.stream()
                .collect(Collectors.groupingBy(Category::getCategory));

        categoryMap.forEach((category, models) -> {
            TreeItem<String> categoryItem = new TreeItem<>(category);
            models.forEach(model -> {
                TreeItem<String> modelItem = new TreeItem<>(model.getProduct());
                categoryItem.getChildren().add(modelItem);
            });
            rootItem.getChildren().add(categoryItem);
        });

        treeView.setRoot(rootItem);
    }

}
