package com.nevada.utdrag.gwt.request;
import java.util.HashSet;
import java.util.Set;
import com.google.gwt.valuestore.shared.Record;
public class ApplicationEntityTypesProcessor {
    private static Set<Class<? extends Record>> instance;
    private static Set<Class<? extends Record>> get() {
        if (instance == null) {
            instance = new HashSet<Class<? extends Record>>();
            instance.add(RegularUserRecord.class);
        }
        return instance;
    }
    public static void processAll(EntityTypesProcessor processor) {
        for (Class<? extends Record> record : get()) {
            processor.processType(record);
        }
    }
    public interface EntityTypesProcessor {
        void processType(Class<? extends Record> record);
    }
}
