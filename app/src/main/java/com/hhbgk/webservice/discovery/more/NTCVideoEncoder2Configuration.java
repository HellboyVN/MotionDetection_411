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

public class NTCVideoEncoder2Configuration extends NTCConfigurationEntity implements KvmSerializable
{

    
    public String Encoding;
    
    public NTCVideoResolution2 Resolution;
    
    public NTCVideoRateControl2 RateControl;
    
    public NTCMulticastConfiguration Multicast;
    
    public Float Quality=0f;
    
    public Integer GovLength=0;
    
    public String Profile;

    public NTCVideoEncoder2Configuration ()
    {
    }

    public NTCVideoEncoder2Configuration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("Encoding"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Encoding = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.Encoding = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("Resolution"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Resolution = (NTCVideoResolution2)__envelope.get(j,NTCVideoResolution2.class,false);
                    }
                    continue;
                }
                if (info.name.equals("RateControl"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.RateControl = (NTCVideoRateControl2)__envelope.get(j,NTCVideoRateControl2.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Multicast"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Multicast = (NTCMulticastConfiguration)__envelope.get(j,NTCMulticastConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Quality"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Quality = new Float(j.toString());
                            }
                        }
                        else if (obj instanceof Float){
                            this.Quality = (Float)obj;
                        }
                    }
                    continue;
                }

            }

        }



        if (inObj.hasAttribute("GovLength"))
        {	
            Object j = inObj.getAttribute("GovLength");
            if (j != null)
            {
                GovLength = Integer.parseInt(j.toString());
	            
            }
        }

        if (inObj.hasAttribute("Profile"))
        {	
            Object j = inObj.getAttribute("Profile");
            if (j != null)
            {
                Profile = j.toString();
	            
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
            return Encoding;
        }
        if(propertyIndex==count+1)
        {
            return Resolution;
        }
        if(propertyIndex==count+2)
        {
            return this.RateControl!=null?this.RateControl:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+3)
        {
            return this.Multicast!=null?this.Multicast:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+4)
        {
            return Quality;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Encoding";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = NTCVideoResolution2.class;
            info.name = "Resolution";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = NTCVideoRateControl2.class;
            info.name = "RateControl";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+3)
        {
            info.type = NTCMulticastConfiguration.class;
            info.name = "Multicast";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+4)
        {
            info.type = Float.class;
            info.name = "Quality";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }



    @Override
    public int getAttributeCount() {
        return super.getAttributeCount() + 2;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        int count=super.getAttributeCount();
        if(index==count+0)
        {
            info.name = "GovLength";
            info.namespace= "";
            if(this.GovLength!=null)
            {
                info.setValue(this.GovLength);
            }
            
        }
        if(index==count+1)
        {
            info.name = "Profile";
            info.namespace= "";
            if(this.Profile!=null)
            {
                info.setValue(this.Profile);
            }
            
        }
        if(index < count)
        {
            super.getAttributeInfo(index, info);
        }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}

