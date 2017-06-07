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

public class NTCPTControlDirectionOptions extends AttributeContainer implements KvmSerializable
{

    
    public NTCEFlipOptions EFlip;
    
    public NTCReverseOptions Reverse;
    
    public NTCPTControlDirectionOptionsExtension Extension;

    public NTCPTControlDirectionOptions ()
    {
    }

    public NTCPTControlDirectionOptions (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("EFlip"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.EFlip = (NTCEFlipOptions)__envelope.get(j,NTCEFlipOptions.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Reverse"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Reverse = (NTCReverseOptions)__envelope.get(j,NTCReverseOptions.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Extension"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Extension = (NTCPTControlDirectionOptionsExtension)__envelope.get(j,NTCPTControlDirectionOptionsExtension.class,false);
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
            return this.EFlip!=null?this.EFlip:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.Reverse!=null?this.Reverse:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = NTCEFlipOptions.class;
            info.name = "EFlip";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = NTCReverseOptions.class;
            info.name = "Reverse";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = NTCPTControlDirectionOptionsExtension.class;
            info.name = "Extension";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

