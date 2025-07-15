let createAccount = document.getElementById("create-account");
let blurBox = document.getElementById("blur-box");
let createAccForm = document.getElementById("create-acc-form");
let createAccCancel = document.getElementById("cancel-create-acc");
let createAccBtn = document.getElementById("create-acc-btn");
let accountbox = document.getElementById("accounts");
let addAmoutBox = document.getElementById("add-amount-box");
let addAmountCencel = document.getElementById("add-amount-cancel");
let expAmountform = document.getElementById("exp-amount-box");
let expAmountCancel = document.getElementById("exp-amount-cancel");
let expAmountBtn = document.getElementById("exp-amt-btn");
let trpAmountform = document.getElementById("trp-amount-box");
let trpAmountCancel = document.getElementById("trp-amount-cancel");
let trpAmountBtn = document.getElementById("trp-amt-btn");
let addAmountBtn = document.getElementById("add-amt-btn");
let trpTo = document.getElementById("trp-to");
let trasactionCancel = document.getElementById("trans-cancel");
let trasactionsBox = document.getElementById("transactions-box");

let selectedId = -1;

createAccount.addEventListener("click", () => {
  blurBox.style.display = "flex";
  createAccForm.style.display = "flex";
});

createAccCancel.addEventListener("click", () => {
  createAccForm.style.display = "none";
  blurBox.style.display = "none";
});

function resetAccounts() {
  accountbox.innerHTML = "";
  let req = new XMLHttpRequest();
  req.open("get", "getAccounts.do", false);

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      let resp = JSON.parse(req.responseText);
      // console.log(resp);
      for (let obj of resp) {
        let acc = document.createElement("div");
        acc.className = "account";
        let ap = document.createElement("p");
        ap.innerText = "savings";
        acc.appendChild(ap);

        let div1 = document.createElement("div");
        let d1h = document.createElement("h1");
        d1h.innerText = obj["name"];
        div1.appendChild(d1h);
        let d1s = document.createElement("span");
        d1s.innerText = "Current Balance = " + obj["balance"];
        div1.appendChild(d1s);
        acc.appendChild(div1);

        let sp2 = document.createElement("span");
        let b1 = document.createElement("button");
        let b2 = document.createElement("button");
        let b3 = document.createElement("button");
        let b4 = document.createElement("button");
        sp2.appendChild(b1);
        b1.innerText = "Add Amount";
        b1.className = "temp";
        b1.id = "ad-" + obj["accountId"];

        sp2.appendChild(b2);
        b2.className = "temp";
        b2.id = "exp-" + obj["accountId"];
        b2.innerText = "Expense";

        sp2.appendChild(b3);
        b3.className = "temp";
        b3.id = "trp-" + obj["accountId"];
        b3.innerText = "Transfer";

        sp2.appendChild(b4);
        b4.innerText = "Transections";
        b4.id = "tras-" + obj["accountId"];
        b4.className = "temp";

        acc.appendChild(sp2);
        accountbox.appendChild(acc);
      }
    }
  });

  req.send();
}

resetAccounts();

createAccBtn.addEventListener("click", (e) => {
  e.preventDefault();
  let req = new XMLHttpRequest();
  req.open("post", "create_account.do", false);

  let name = document.getElementById("acc-name").value;
  let balance = document.getElementById("acc-balance").value;

  let params = "name=" + name + "&balance=" + balance;
  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      if (req.responseText == "true") {
        createAccForm.style.display = "none";
        blurBox.style.display = "none";
        document.forms[0].reset();
        resetAccounts();
      } else {
        createAccForm.style.boxShadow = "0 0 5px red";
      }
    }
  });

  req.send(params);
});

function addAmount(id) {
  blurBox.style.display = "flex";
  addAmoutBox.style.display = "flex";

}

function expAmount(id) {
  blurBox.style.display = "flex";
  expAmountform.style.display = "flex";
}

function trpAmount(id) {
  blurBox.style.display = "flex";
  trpAmountform.style.display = "flex";
  let req = new XMLHttpRequest();
  req.open("get", "getAccounts.do", false);

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      let resp = JSON.parse(req.responseText);
      // console.log(resp)
      trpTo.innerHTML="";
      for(let obj of resp){
        let opname = obj["name"];
        let objId = obj["accountId"];
        if(objId != id){
          let opt = document.createElement('option');
          opt.value = objId;
          opt.innerText = opname;
          trpTo.appendChild(opt);
        }

      }
    }else{
      blurBox.style.display = "none";
      trpAmountform.style.display = "none";
    }
  });

  req.send();
}

trpAmountCancel.addEventListener("click", () => {
  blurBox.style.display = "none";
  trpAmountform.style.display = "none";
});

expAmountCancel.addEventListener("click", () => {
  blurBox.style.display = "none";
  expAmountform.style.display = "none";
});

trasactionCancel.addEventListener('click',()=>{
  trasactionsBox.style.display = "none";
  blurBox.style.display = "none";
})

addAmountCencel.addEventListener("click", () => {
  addAmoutBox.style.display = "none";
  blurBox.style.display = "none";
});



function ReloadTrasactions(){
  
  let req = new XMLHttpRequest();
  req.open("post", "get_trasactions.do", false);

  let params = "id=" + selectedId;
  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");

  req.addEventListener("readystatechange", () => {
    
    if (req.readyState == 4 && req.status == 200) {
      let resp = JSON.parse(req.responseText);
      // console.log(resp)

      let allTransactionBox = document.getElementById("all-transactions");
      allTransactionBox.innerHTML = "";

      for(let obj of resp){
        let div1 = document.createElement("div");
        div1.className = "transaction";

        let div11 = document.createElement("div");
        let sp1 = document.createElement("span")
        sp1.innerText = "Transaction Id - " + obj["transactionId"];
        let sp2 = document.createElement("span")
        sp2.innerText = "Trasaction Type - " + obj["type"];
        div11.appendChild(sp1)
        div11.appendChild(sp2)


        let div12 = document.createElement("div");
        let sp3 = document.createElement("span")
        sp3.innerText = "Amount - " + obj["balance"];
        let sp4 = document.createElement("span")
        sp4.innerText = "Time - " + obj["time"];
        div12.appendChild(sp3)
        div12.appendChild(sp4)

        let div13 = document.createElement("div");
        div13.innerText = "Remark -- " + obj["remark"];

        div1.appendChild(div11)
        div1.appendChild(div12)
        div1.appendChild(div13)
        allTransactionBox.appendChild(div1);
      }
    }
  });

  req.send(params);
}


accountbox.addEventListener("click", (e) => {
  let trg = e.target.closest(".temp");
  let clName = trg.className;

  if (clName == "temp") {
    let x = (trg.id + "").split("-");
    let op = x[0];
    let id = x[1];

    selectedId = id;
    if (op == "ad") {
      addAmount(id);
    } else if (op == "exp") {
      expAmount(id);
    } else if (op == "trp") {
      trpAmount(id);
    } else if (op == "tras") {
      trasactionsBox.style.display = "block";
      blurBox.style.display = "flex";
      ReloadTrasactions();
    }
  }
});

addAmountBtn.addEventListener("click", (e) => {
  e.preventDefault();
  let amount = document.getElementById("add-amt").value;
  let remark = document.getElementById("add-remark").value;
  let req = new XMLHttpRequest();
  req.open("post", "add_amount.do", false);

  let params = "amount=" + amount + "&remark=" + remark + "&id=" + selectedId;
  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      if (req.responseText == "true") {
        addAmoutBox.style.display = "none";
        blurBox.style.display = "none";
        let forms = document.forms;
        forms[1].reset();
        resetAccounts();
      } else {
        addAmoutBox.style.boxShadow = "0 0 5px red";
      }
    }
  });

  req.send(params);
});


trpAmountBtn.addEventListener('click',(e)=>{
  e.preventDefault();
  // console.log(trpTo.value);
  let trpRemarkval = document.getElementById("trp-remark").value;
  let trpamt = document.getElementById("trp-amt").value;
  // console.log(selectedId)

  let req = new XMLHttpRequest();
  req.open("post", "tranfer.do", false);

  let params = "from=" + selectedId + "&to=" + trpTo.value + "&amount=" + trpamt+"&remark="+trpRemarkval;
  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      if (req.responseText == "true") {
        trpAmountform.style.display = "none";
        blurBox.style.display = "none";
        document.forms[3].reset()
        resetAccounts();
      } else {
        trpAmountform.style.boxShadow = "0 0 5px red";
      }
    }
  });

  req.send(params);


})


expAmountBtn.addEventListener('click',(e)=>{
  e.preventDefault();
  let req = new XMLHttpRequest();
  req.open("post", "expense.do", false);
  let amount = document.getElementById("exp-amt").value;
  let remark = document.getElementById("exp-remark").value;

  let params = "id=" + selectedId + "&amount=" + amount + "&remark="+remark;
  req.setRequestHeader("content-type", "application/x-www-form-urlencoded");

  req.addEventListener("readystatechange", () => {
    if (req.readyState == 4 && req.status == 200) {
      if (req.responseText == "true") {
        expAmountform.style.display = "none";
        document.forms[2].reset();
        blurBox.style.display = "none";
        resetAccounts();
      } else {
        expAmountform.style.boxShadow = "0 0 5px red";
      }
    }
  });

  req.send(params);
})