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
  TouchableHighlight,
  Dimensions,
  ListView
} from 'react-native';
import SGListView from 'react-native-sglistview';
import styles from './app/utils/css/hero-style';
import ToastAndroid from './ToastAndroid';
import codePush from "react-native-code-push";
var deviceWidth = Dimensions.get('window').width;
class HeroComponent extends Component {
  renderSlug(){
   if (this.props.rowID.slug) {
     return (
       <Text style={styles.slug}>{this.props.rowID.slug}+"Hi"</Text>
     );
   }
 }
 _click(title) {
    console.log('clicked : '+title);
    ToastAndroid.showInParent('Cliked : '+title, ToastAndroid.SHORT);
    };
 render() {
   var imageUrl = `${this.props.rowID.image}`;
   let pic = {
     uri: imageUrl
   };
   return (
   <TouchableHighlight onPress={() => {this._click(this.props.rowID.title);}}>
     <View style={{flex: 1, flexDirection: 'column',padding: 10}}>
     { this.renderSlug() }
        <Image 
        source={pic} 
        style={{
          flex: 1,
          height: 180,
          width: deviceWidth*0.95,
          overflow: 'visible'
        }}
      />
      {/*   <ImageLoader
                   style={{width: 420, height: 180}}
                   options={{
                    rowID: this.props.rowID,
                    src: 'https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg',
                    placeholder: "goods-placeholder",
                    }}
       /> */}
      <Text style={styles.hero_title}>{this.props.rowID.title}</Text>
    </View>
    </TouchableHighlight>
   );
 }
}

class VillainComponent extends Component {
 
  renderSlug(){
   if (this.props.rowID.slug) {
     return (
       <Text style={styles.slug}>{this.props.rowID.slug}</Text>
     );
   }
 }
 
 render() {
  var imageUrl = `${this.props.rowID.image}`;
  let pic = {
     uri: imageUrl
   };
   return (
    <View style={{flex: 1, flexDirection: 'column',padding: 10}}>
      { this.renderSlug() }
      <View style={{flex:1, flexDirection : 'row', backgroundColor: '#CCCCCC'}}>
        <Image source={pic} style={{width:120, height: 150}}/>
        <View style={{flex: 1, flexDirection: 'column'}}>
          <Text style={styles.hero_title}>{this.props.rowID.title}</Text>
          <Text style={styles.hero_summary}>{this.props.rowID.summary}</Text>
        </View>
      </View>
    </View>
   );
 }
}
export default class devdactic_react extends Component {
// Initialize the hardcoded data
 constructor(props) {
   super(props);
   console.log(this.props.feeds);
   var data = JSON.parse(this.props.feeds);
   const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
   this.state = {
     dataSource: ds.cloneWithRows(data)
   };
 }
 componentDidMount() {
         codePush.sync({
            updateDialog: true,
            installMode: codePush.InstallMode.IMMEDIATE
        });
     }
 render() {

   return (
     <View style={{backgroundColor: '#808080',flex: 1}}>
       <ListView
         dataSource={this.state.dataSource}
         renderRow={this._renderRow}
       />
     </View>
   );
 }

 _renderRow = (rowID,feeds) => {
    var typ = rowID.type;
    if(typ === "Hero") return <HeroComponent rowID = {rowID} feeds = {this.props.feeds}/>;
    if(typ === "Villain") return <VillainComponent rowID = {rowID} feeds = {this.props.feeds}/>;
    return null;
 }
 }
let codePushOptions = { checkFrequency: codePush.CheckFrequency.ON_APP_RESUME };
devdactic_react = codePush(codePushOptions)(devdactic_react);
AppRegistry.registerComponent('AwesomeProject', () => devdactic_react);
