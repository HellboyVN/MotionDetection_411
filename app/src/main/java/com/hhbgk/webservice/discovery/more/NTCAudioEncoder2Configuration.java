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

public class NTCAudioEncoder2Configuration extends NTCConfigurationEntity implements KvmSerializable
{

    
    public String Encoding;
    
    public NTCMulticastConfiguration Multicast;
    
    public Integer Bitrate=0;
    
    public Integer SampleRate=0;

    public NTCAudioEncoder2Configuration ()
    {
    }

    public NTCAudioEncoder2Configuration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("Multicast"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Multicast = (NTCMulticastConfiguration)__envelope.get(j,NTCMulticastConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Bitrate"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Bitrate = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.Bitrate = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("SampleRate"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.SampleRate = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.SampleRate = (Integer)obj;
                        }
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
            return Encoding;
        }
        if(propertyIndex==count+1)
        {
            return this.Multicast!=null?this.Multicast:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return Bitrate;
        }
        if(propertyIndex==count+3)
        {
            return SampleRate;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+4;
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
            info.type = NTCMulticastConfiguration.class;
            info.name = "Multicast";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Bitrate";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+3)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "SampleRate";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

