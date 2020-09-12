function FindProxyForURL(url, host)
{
   if (isPlainHostName(host) ||
       dnsDomainIs(host, ".foobar"))
       return "DIRECT";
    else
        if (isInNet(myIpAddress(), "192.168.1.3", "255.255.0.0"))
            return "PROXY 192.168.1.3:3128; DIRECT";
        else
            return "DIRECT";
}
