package com.example.design;

import java.util.ArrayList;
import java.util.List;

abstract class ExampleComponentAbstract {
    String text;

    ExampleComponentAbstract(String text) {
        this.text = text;
    }
}

class ExampleItem extends ExampleComponentAbstract {
    ExampleItem(String text) {
        super(text);
    }
}

class ExampleComposite extends ExampleComponentAbstract {
    List<ExampleComponentAbstract> components = new ArrayList<>();

    ExampleComposite(String text) {
        super(text);
    }
}

class Test {
    public static void main(String[] args) {
        ExampleComposite dir_node = new ExampleComposite("directory");
        dir_node.components.add(new ExampleItem("create"));
        dir_node.components.add(new ExampleItem("update owner"));
        dir_node.components.add(new ExampleItem("add file"));
        dir_node.components.add(new ExampleItem("delete"));

        ExampleComposite file_node = new ExampleComposite("file");
        file_node.components.add(new ExampleItem("edit"));
        dir_node.components.add(file_node);

        System.out.println(dir_node);

    }
}