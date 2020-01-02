package org.nervelinkin.core;

public enum SemaphoreType{
    SensationSemaphore(0,"感觉信号"),
    CognitionSemaphore(1,"认知信号"),
    ActionSemaphore(2,"动作信号"),
    SearchSemaphore(3,"搜索信号");
    private int no;
    private String name;

    SemaphoreType(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
