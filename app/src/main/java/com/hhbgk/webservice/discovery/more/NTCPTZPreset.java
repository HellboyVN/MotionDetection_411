package com.hhbgk.webservice.discovery.more;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.0
//
// Created by Quasar Development at 04/04/2017
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.AttributeInfo;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class NTCPTZPreset extends AttributeContainer implements KvmSerializable
{

    
    public String Name;
    
    public NTCPTZVector PTZPosition;
    
    public String token;

    public NTCPTZPreset ()
    {
    }

    public NTCPTZPreset (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                //if you have compilation error here, please use a ksoap2.jar and ExKsoap2.jar from libs folder (in the generated zip file)
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                Object obj = info.getValue();
                if (info.name.equals("Name"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Name = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.Name = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("PTZPosition"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.PTZPosition = (NTCPTZVector)__envelope.get(j,NTCPTZVector.class,false);
                    }
                    continue;
                }

            }

        }



        if (inObj.hasAttribute("token"))
        {	
            Object j = inObj.getAttribute("token");
            if (j != null)
            {
                token = j.toString();
	            
            }
        }

    }

    @Override
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.Name!=null?this.Name:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.PTZPosition!=null?this.PTZPosition:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Name";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = NTCPTZVector.class;
            info.name = "PTZPosition";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }



    @Override
    public int getAttributeCount() {
        return 1;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if(index==0)
        {
            info.name = "token";
            info.namespace= "";
            if(this.token!=null)
            {
                info.setValue(this.token);
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
