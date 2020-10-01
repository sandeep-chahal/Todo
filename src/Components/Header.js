import React, { Component } from 'react'

export class Header extends Component {
  
        constructor(props) {
            super(props)
        
            this.state = {
                 
            }
        }
        render() {
        return (
            <div>
                <header>
                    <nav style={{backgroundColor:'lightblue',fontFamily:'cursive' , textAlign:'center'}}>
                     <div style={{color:'black', fontSize:30,fontFamily:'cursive'}}>
                         Todo Management Application
                     </div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default Header
