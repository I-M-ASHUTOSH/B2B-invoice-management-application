import React, { useState } from "react";
import { Tab,Button, TextField, Tabs, Typography } from "@material-ui/core";
import TableMUI from "./TableMUI";
import AddData from "./AddData";
import SearchR from "./SearchR";
import AnalyticsView from "./AnalyticsView";

function TabPanel({ children, value, index }) {
  return (
    <div hidden={value !== index}>
      {value === index && (
        <Typography component="div" style={{ padding: 8 }}>
          {children}
        </Typography>
      )}
    </div>
  );
}

export default function Tabsb() {
  const [value, setValue] = useState(0);
  const [showHiddenTab, setShowHiddenTab] = useState(false);
  const [searchValue, setSearchValue] = useState("");
  const [open, setOpen] = useState(false);

  const handleChange = (event,newValue) => {
    setValue(newValue);
  };

  const handleInputChange = (event) => {
    setSearchValue(event.target.value);
  };

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSave = () => {
    
    handleClose();
  };


  const handleKeyDown = (event) => {
    if(event.key === 'Enter'){
    setShowHiddenTab(true);
    setValue(3);
     // incomplete search logic /
   //  setSearchResult(searchValue); // Setting the search result as the entered value
     console.log("SearchValue:",searchValue);
    }
  };

  return (
    <div>
      <div
        style={{
          flexGrow: 3,
          backgroundColor: "#666666",
          marginLeft: "13px",
          marginRight: "13px",
          marginBottom: "-91px",
          height: "80px",
          marginTop: "-20px"
        }}
      >
        <Tabs
          value={value}
          onChange={handleChange}
          style={{ color: "white" }}
          TabIndicatorProps={{
            style: {
              backgroundColor: "white",
            },
          }}
        >
          <Tab label="Home Page" style={{marginTop: "15px"}} />
          <Tab label="Add Data" style={{marginTop: "15px"}}/>
          <Tab label="Analytics View" style={{marginTop: "15px"}} />
          {showHiddenTab ? (
            <Tab label="Search Result" style={{marginTop: "15px" , }} />
          ) : ( 
          
            <TextField
            label="CUSTOMER ORDER ID"
            name="CUSTOMER_ORDER_ID"
            value={searchValue}
            onChange={handleInputChange}
            onKeyDown={handleKeyDown}
            variant="outlined"
            style={{marginTop:"15px",marginLeft:"650px",  backgroundColor:"white",
            borderRadius:"8px"}}
            
          />
          )}
        </Tabs>
        <Tab>
        <Button variant="contained" onClick={handleOpen} style={{
              color: "white",
              backgroundColor: "#fc7500",
              marginRight: "10px",
      }}>
        ADVANCED SERACHED 
      </Button>
        </Tab>
      </div>
      <div style={{ flexGrow: 2 }}>
        <TabPanel value={value} index={0}>
          <TableMUI />
        </TabPanel>
        <TabPanel value={value} index={1}>
          <AddData /> 
        </TabPanel>
        <TabPanel value={value} index={2}>
          <AnalyticsView />
        </TabPanel>
        <TabPanel value={value} index={3}>
          <SearchR/>
        </TabPanel>
     
      </div>
      <div>
      
      </div>
    </div>
  );
}
