## Teltonika Device Config

Establish a base config for Teltonika devices. Unfortunately the devices do not use an XML /JSON type file for config so the important changes are documented in this markdown document.

!!! Important: When USB cable is connected no device data is sent.

#### Status

- Device INFO
    * Internal Battery Status Not charging %
- TABS
    + GNSS Info
        * nothing to change
    + GSM INfo
        * Reset counters
    + IO
        * Sleep mode 0
    + Maintenance
        * Log
    
#### Security
- pin codes

#### System
- Suggested setting: Online Deep Sleep allows for modem SMS communications

#### GPRS
- Server Settings
    + Domain: teltonika.qone.cloud-apps.tvh.com
    + Backup Server Domain: 23.89.198.205 (TVH FDM squad)

#### Data Acquisition
- Flash memory
- Changed number of saved records min saved records from 1 - 10

#### SMS \Call Settings
     
- Set Authorized Number


| First Header  | Second Header |
| ------------- | ------------- |
| Content Cell  | Content Cell  |
| Content Cell  | Content Cell  |


#### GSM Operators
#### Operators
#### Features
#### Accelerometer Features
#### Auto GeoFence
#### Manual GeoFence
#### Trip /Odometer
#### Bluetooth 
- Enable visible
    + name blank
    + local pin 

#### Bluetooth 4.0

#### iButton List

###  IO
ignition

### OBD II