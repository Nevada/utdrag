package com.nevada.utdrag;

import com.nevada.utdrag.RegularUser;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

privileged aspect RegularUserDataOnDemand_Roo_DataOnDemand {
    
    declare @type: RegularUserDataOnDemand: @Component;
    
    private Random RegularUserDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<RegularUser> RegularUserDataOnDemand.data;
    
    public RegularUser RegularUserDataOnDemand.getNewTransientRegularUser(int index) {
        com.nevada.utdrag.RegularUser obj = new com.nevada.utdrag.RegularUser();
        return obj;
    }
    
    public RegularUser RegularUserDataOnDemand.getSpecificRegularUser(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        RegularUser obj = data.get(index);
        return RegularUser.findRegularUser(obj.getId());
    }
    
    public RegularUser RegularUserDataOnDemand.getRandomRegularUser() {
        init();
        RegularUser obj = data.get(rnd.nextInt(data.size()));
        return RegularUser.findRegularUser(obj.getId());
    }
    
    public boolean RegularUserDataOnDemand.modifyRegularUser(RegularUser obj) {
        return false;
    }
    
    public void RegularUserDataOnDemand.init() {
        if (data != null && !data.isEmpty()) {
            return;
        }
        
        data = com.nevada.utdrag.RegularUser.findRegularUserEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'RegularUser' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<com.nevada.utdrag.RegularUser>();
        for (int i = 0; i < 10; i++) {
            com.nevada.utdrag.RegularUser obj = getNewTransientRegularUser(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
