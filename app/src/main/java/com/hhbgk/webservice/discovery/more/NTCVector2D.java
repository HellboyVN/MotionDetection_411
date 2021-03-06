package com.hhbgk.webservice.discovery.more;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.0
//
// Created by Quasar Development at 04/04/2017
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class NTCVector2D extends AttributeContainer implements KvmSerializable
{

    
    public Float x=0f;
    
    public Float y=0f;
    
    public String space;

    public NTCVector2D ()
    {
    }

    public NTCVector2D (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;







        if (inObj.hasAttribute("x"))
        {	
            Object j = inObj.getAttribute("x");
            if (j != null)
            {
                x = new Float(j.toString());
	            
            }
        }

        if (inObj.hasAttribute("y"))
        {	
            Object j = inObj.getAttribute("y");
            if (j != null)
            {
                y = new Float(j.toString());
	            
            }
        }

        if (inObj.hasAttribute("space"))
        {	
            Object j = inObj.getAttribute("space");
            if (j != null)
            {
                space = j.toString();
	            
            }
        }

    }

    @Override
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }



    @Override
    public int getAttributeCount() {
        return 3;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if(index==0)
        {
            info.name = "x";
            info.namespace= "";
            if(this.x!=null)
            {
                info.setValue(this.x);
            }
            
        }
        if(index==1)
        {
            info.name = "y";
            info.namespace= "";
            if(this.y!=null)
            {
                info.setValue(this.y);
            }
            
        }
        if(index==2)
        {
            info.name = "space";
            info.namespace= "";
            if(this.space!=null)
            {
                info.setValue(this.space);
            }
            
        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}

