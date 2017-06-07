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

public class NTCAudioOutputConfiguration extends NTCConfigurationEntity implements KvmSerializable
{

    
    public String OutputToken;
    
    public String SendPrimacy;
    
    public Integer OutputLevel=0;

    public NTCAudioOutputConfiguration ()
    {
    }

    public NTCAudioOutputConfiguration (Object paramObj,NTCExtendedSoapSerializationEnvelope __envelope)
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
                if (info.name.equals("OutputToken"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.OutputToken = j.toString();
                            }
                        }
                        else if (obj instanceof String){
                            this.OutputToken = (String)obj;
                        }
                    }
                    continue;
                }
                if (info.name.equals("SendPrimacy"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.SendPrimacy = j.toString();
                            }
                        }
                        else{
                            this.SendPrimacy = obj.toString();
                        }
                    }
                    continue;
                }
                if (info.name.equals("OutputLevel"))
                {
                    if(obj!=null)
                    {
        
                        if (obj.getClass().equals(SoapPrimitive.class))
                        {
                            SoapPrimitive j =(SoapPrimitive) obj;
                            if(j.toString()!=null)
                            {
                                this.OutputLevel = Integer.parseInt(j.toString());
                            }
                        }
                        else if (obj instanceof Integer){
                            this.OutputLevel = (Integer)obj;
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
            return OutputToken;
        }
        if(propertyIndex==count+1)
        {
            return this.SendPrimacy!=null?this.SendPrimacy:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+2)
        {
            return OutputLevel;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "OutputToken";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "SendPrimacy";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        if(propertyIndex==count+2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "OutputLevel";
            info.namespace= "http://www.onvif.org/ver10/schema";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }
    
    @Override
    public void setProperty(int arg0, Object arg1)
    {
    }

    
}
