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

public class NTCEventSubscription extends AttributeContainer implements KvmSerializable
{

    
    public NTCFilterType Filter;
    
    public NTCEventSubscription_SubscriptionPolicy SubscriptionPolicy;

    public NTCEventSubscription ()
    {
    }

    public NTCEventSubscription (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("Filter"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Filter = (NTCFilterType)__envelope.get(j,NTCFilterType.class,false);
                    }
                    continue;
                }
                if (info.name.equals("SubscriptionPolicy"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.SubscriptionPolicy = (NTCEventSubscription_SubscriptionPolicy)__envelope.get(j,NTCEventSubscription_SubscriptionPolicy.class,false);
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
            return this.Filter!=null?this.Filter:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.SubscriptionPolicy!=null?this.SubscriptionPolicy:SoapPrimitive.NullSkip;
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
            info.type = NTCFilterType.class;
            info.name = "Filter";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = NTCEventSubscription_SubscriptionPolicy.class;
            info.name = "SubscriptionPolicy";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

