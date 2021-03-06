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

public class NTCMulticastConfiguration extends AttributeContainer implements KvmSerializable
{

    
    public NTCIPAddress Address;
    
    public Integer Port=0;
    
    public Integer TTL=0;
    
    public Boolean AutoStart=false;

    public NTCMulticastConfiguration ()
    {
    }

    public NTCMulticastConfiguration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("Address"))
                {
                    if(obj!=null)
                    {
                        Object j = obj;
                        this.Address = (NTCIPAddress)__envelope.get(j,NTCIPAddress.class,false);
                    }
                    continue;
                }
                if (info.name.equals("Port"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.Port = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.Port = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("TTL"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.TTL = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.TTL = (Integer)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("AutoStart"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.AutoStart = new Boolean(j.toString());
                            }
                        }
                        else if (obj instanceof Boolean){
                            this.AutoStart = (Boolean)obj;
                        }
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
            return Address;
        }
        if(propertyIndex==1)
        {
            return Port;
        }
        if(propertyIndex==2)
        {
            return TTL;
        }
        if(propertyIndex==3)
        {
            return AutoStart;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = NTCIPAddress.class;
            info.name = "Address";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Port";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "TTL";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "AutoStart";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}

