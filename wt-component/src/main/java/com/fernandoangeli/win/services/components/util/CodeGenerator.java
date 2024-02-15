package com.fernandoangeli.win.services.components.util;

public class CodeGenerator {

    private final static Integer INDEXADOR = 100000;

    public static Integer CodeGenerator(Long componentType, Long componentId){
        return componentType.intValue()*INDEXADOR + (componentId.intValue());
    }

}
