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

public class NTCFocusConfiguration20 extends AttributeContainer implements KvmSerializable
{

    
    public NTCEnums.AutoFocusMode AutoFocusMode=NTCEnums.AutoFocusMode.AUTO;
    
    public Float DefaultSpeed;
    
    public Float NearLimit;
    
    public Float FarLimit;
    
    public NTCFocusConfiguration20Extension Extension;

    public NTCFocusConfiguration20 ()
    {
    }

    public NTCFocusConfiguration20 (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("AutoFocusMode"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.AutoFocusMode = NTCEnums.AutoFocusMode.fromString(j.toString());
                            }
                        }
                        else if (obj instanceof NTCEnums.AutoFocusMode){
                            this.AutoFocusMode = (NTCEnums.AutoFocusMode)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("DefaultSpeed"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.DefaultSpeed = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.DefaultSpeed = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("NearLimit"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.NearLimit = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.NearLimit = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("FarLimit"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.FarLimit = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.FarLimit = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCFocusConfiguration20Extension)__envelope.get(j,NTCFocusConfiguration20Extension.class,false);
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.AutoFocusMode!=null?this.AutoFocusMode.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.DefaultSpeed!=null?this.DefaultSpeed:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.NearLimit!=null?this.NearLimit:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.FarLimit!=null?this.FarLimit:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "AutoFocusMode";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = Float.class;
            info.name = "DefaultSpeed";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = Float.class;
            info.name = "NearLimit";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==3)
        {
            info.type = Float.class;
            info.name = "FarLimit";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==4)
        {
            info.type = NTCFocusConfiguration20Extension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

