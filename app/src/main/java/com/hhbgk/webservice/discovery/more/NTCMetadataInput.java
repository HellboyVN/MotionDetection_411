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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class NTCMetadataInput extends AttributeContainer implements KvmSerializable
{

    
    public ArrayList< NTCConfig> MetadataConfig =new ArrayList<NTCConfig >();
    
    public NTCMetadataInputExtension Extension;

    public NTCMetadataInput ()
    {
    }

    public NTCMetadataInput (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("MetadataConfig"))
                {
                    if(obj!=null)
                    {
        
                    
                        if(this.MetadataConfig==null)
                        {
                            this.MetadataConfig = new ArrayList< NTCConfig>();
                        }
                        Object j =obj;
                        NTCConfig j1= (NTCConfig)__envelope.get(j,NTCConfig.class,false);
                        this.MetadataConfig.add(j1);
                   
        
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCMetadataInputExtension)__envelope.get(j,NTCMetadataInputExtension.class,false);
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
        if(propertyIndex>=0 && propertyIndex < 0+this.MetadataConfig.size())
        {
            return this.MetadataConfig.get(propertyIndex-(0));
        }
        if(propertyIndex==0+this.MetadataConfig.size())
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+MetadataConfig.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.MetadataConfig.size())
        {
            info.type = NTCConfig.class;
            info.name = "MetadataConfig";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==0+this.MetadataConfig.size())
        {
            info.type = NTCMetadataInputExtension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

