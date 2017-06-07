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

public class NTCVideoOutput extends NTCDeviceEntity implements KvmSerializable
{

    
    public NTCLayout Layout;
    
    public NTCVideoResolution Resolution;
    
    public Float RefreshRate;
    
    public Float AspectRatio;
    
    public NTCVideoOutputExtension Extension;

    public NTCVideoOutput ()
    {
    }

    public NTCVideoOutput (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
    {
	    super(paramObj, __envelope);
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
                if (info.name.equals("Layout"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Layout = (NTCLayout)__envelope.get(j,NTCLayout.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Resolution"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Resolution = (NTCVideoResolution)__envelope.get(j,NTCVideoResolution.class,false);
                    }
                    continue;
                }
                if (info.name.equals("RefreshRate"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.RefreshRate = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.RefreshRate = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("AspectRatio"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.AspectRatio = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.AspectRatio = (Float)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCVideoOutputExtension)__envelope.get(j,NTCVideoOutputExtension.class,false);
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==count+0)
        {
            return Layout;
        }
        if(propertyIndex==count+1)
        {
            return this.Resolution!=null?this.Resolution:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return this.RefreshRate!=null?this.RefreshRate:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+3)
        {
            return this.AspectRatio!=null?this.AspectRatio:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+4)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+5;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = NTCLayout.class;
            info.name = "Layout";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = NTCVideoResolution.class;
            info.name = "Resolution";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = Float.class;
            info.name = "RefreshRate";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+3)
        {
            info.type = Float.class;
            info.name = "AspectRatio";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+4)
        {
            info.type = NTCVideoOutputExtension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}
