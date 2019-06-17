package com.datawisher.common.apache.commons.lang3;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;
import org.junit.Test;

public class ArchUtilsTests {

    @Test
    public void testGetProcessor() {
        Processor processor = ArchUtils.getProcessor();
        Processor.Arch arch = processor.getArch();
        Processor.Type type = processor.getType();
        System.out.println(arch);
        System.out.println(type);
        System.out.println(processor);
    }
}
