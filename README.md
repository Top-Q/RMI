RMI
===

Server - RMI producer<br/>
Client- RMI consumer<br/>


both are using Spring framework 
the server expose RMI exporter bean and the client consume via ProxyFactory.<br/>

the server also use Spring 3.1 Profile feature that loads the RMI context only when the profile of "rmi" is selected (false by default)
