/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image,
  ListView
} from 'react-native';
import SGListView from 'react-native-sglistview';
import styles from './app/utils/css/hero-style';

class HeroComponent extends Component {
 render() {
   let pic = {
     uri: 'https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg'
   };
   return (
     <View style={{flex: 1, flexDirection: 'column'}}>
      <Text style={styles.slug}>Slug</Text>
      <Image source={pic} style={{width:480, height: 180}}/>
      <Text style={styles.hero_title}>Lorem ipsum text......
      Lorem ipsum text......Lorem ipsum text......</Text>
    </View>
   );
 }
}

export default class devdactic_react extends Component {
// Initialize the hardcoded data
// Initialize the hardcoded data
 constructor(props) {
   super(props);
   const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
   this.state = {
     dataSource: ds.cloneWithRows(this.props.feeds)
   };
 }
 render() {
   return (
     <View style={{flex: 1, paddingTop: 22}}>
       <ListView
         dataSource={this.state.dataSource}
         renderRow={(rowID,feeds) => <HeroComponent rowID = {rowID} feeds = {this.props.feeds}/>}
       />
     </View>
   );
 }
 }

AppRegistry.registerComponent('AwesomeProject', () => devdactic_react);
