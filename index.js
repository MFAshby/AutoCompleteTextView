// AutoCompleteTextView.js
import React, { PropTypes, Component } from 'react'
import { requireNativeComponent, View, Text } from 'react-native';

var RCTAutoCompleteTextView = requireNativeComponent('RCTAutoCompleteTextView', AutoCompleteTextView, {
  nativeOnly: {onChange: true}
});

class AutoCompleteTextView extends Component {
  constructor(props) {
    super(props);
    this._onChange = this._onChange.bind(this)
  }
  _onChange(event: Event) {
    if (!this.props.onChangeText) {
      return
    }
    this.props.onChangeText(event.nativeEvent.text)
  }
  render() {
    return <RCTAutoCompleteTextView {...this.props} onChange={this._onChange} />
  }
}

AutoCompleteTextView.propTypes = {
  listData: PropTypes.array,
  onChangeText: PropTypes.func,
  ...View.propTypes
}

export default AutoCompleteTextView
