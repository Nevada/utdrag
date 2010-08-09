package com.nevada.utdrag;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect RegularUser_Roo_Configurable {
    
    declare @type: RegularUser: @Configurable;
    
}
