import {
  StyleSheet
} from 'react-native';

import {
  colors,
  shade
} from './style-util'

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
    color: '#333333'
  },
  slug: {
    fontSize: 20,
    fontWeight: 'bold',
    backgroundColor: '#FF0000',
    color: colors.white,
    marginTop: 0,
    paddingTop: 5,
    paddingBottom: 5,
    textAlign: 'center'
  },
  hero_title: {
    fontSize: 20,
    fontWeight: 'bold',
    backgroundColor: '#CCCCCC',
    color: colors.black,
    paddingTop: 10,
    paddingBottom: 10,
    textAlign: 'center'
  },
  hero_summary: {
    fontSize: 16,
    backgroundColor: '#CCCCCC',
    color: colors.black,
    paddingTop: 10,
    paddingBottom: 10,
    paddingLeft:10 
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

export default styles
