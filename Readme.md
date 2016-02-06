# Lv2Library 

Get the info of your Lv2Library (lv2 plugins installed in your computer)

## Dependendencies 

* lv2ls (for getting all the effects)
* lv2info ()
* Node

```
curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -
sudo apt-get install --yes nodejs
```

## Usage

```
Lv2Library myLib = Lv2Library.getInstance();
// Find lv2plugins (and generate json matching)
myLib.initializate();
		
// Show the plugins effects
System.out.println(myLib.getPlugins());
```