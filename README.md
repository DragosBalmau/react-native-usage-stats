
# Note: This library is under construction and the functionality is not added yet
# react-native-react-native-usage-stats-manager

## Getting started

`$ npm install react-native-usage-stats-manager --save`

### Mostly automatic installation

`$ react-native link react-native-usage-stats-manager`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeUsageStatsManagerPackage;` to the imports at the top of the file
  - Add `new RNReactNativeUsageStatsManagerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-usage-stats-manager'
  	project(':react-native-usage-stats-manager').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-usage-stats-manager/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-usage-stats-manager')
  	```


## Usage
```javascript
import RNReactNativeUsageStatsManager from 'react-native-usage-stats-manager';

// TODO: What to do with the module?
RNReactNativeUsageStatsManager;
```

