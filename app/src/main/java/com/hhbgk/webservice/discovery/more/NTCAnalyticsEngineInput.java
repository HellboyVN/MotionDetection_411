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

public class NTCAnalyticsEngineInput extends NTCConfigurationEntity implements KvmSerializable
{

    
    public NTCSourceIdentification SourceIdentification;
    
    public NTCVideoEncoderConfiguration VideoInput;
    
    public NTCMetadataInput MetadataInput;

    public NTCAnalyticsEngineInput ()
    {
    }

    public NTCAnalyticsEngineInput (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("SourceIdentification"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.SourceIdentification = (NTCSourceIdentification)__envelope.get(j,NTCSourceIdentification.class,false);
                    }
                    continue;
                }
                if (info.name.equals("VideoInput"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.VideoInput = (NTCVideoEncoderConfiguration)__envelope.get(j,NTCVideoEncoderConfiguration.class,false);
                    }
                    continue;
                }
                if (info.name.equals("MetadataInput"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.MetadataInput = (NTCMetadataInput)__envelope.get(j,NTCMetadataInput.class,false);
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
            return SourceIdentification;
        }
        if(propertyIndex==count+1)
        {
            return VideoInput;
        }
        if(propertyIndex==count+2)
        {
            return MetadataInput;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = NTCSourceIdentification.class;
            info.name = "SourceIdentification";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = NTCVideoEncoderConfiguration.class;
            info.name = "VideoInput";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = NTCMetadataInput.class;
            info.name = "MetadataInput";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

