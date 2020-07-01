<script src="assets/js/bootstrap.min.js"></script>
    <div class="header">
        <div class="fl-menu">
            <a class="login" href="libraryHome.jsp">
                <button type="button" class=" btn-lg">
                    <span class="glyphicon glyphicon-home"></span> Return
                </button>
            </a>
        </div>
        <div class="navbar-menu">
         
                <button type="button" class=" btn-lg">
                    <span class="glyphicon glyphicon-user"></span><span> ${sessionScope.ReaderEntity.name}</span></a>
            </button>
           
        </div>
    </div>
    <div class="left-menue">
        <ul class="items">
            <li><a href="readerSearchBook.jsp">Search Book</a> </li>
            <li><a href="ReaderBorrowCart">Borrow Cart</a> </li>
            <li>
                <a href="#subPages1" data-toggle="collapse" class="collapsed">
                    <span class="smallGap">Borrow Record</span>
                    <span class="glyphicon glyphicon-menu-down"></span>
                </a>
                <div id="subPages1" class="collapse ">
                    <ul class="nav">
                        <li><a href="ReaderBorrowHistory" class=""><span>Borrow History</span></a></li>
                        <li><a href="ReaderReturnHistory" class=""><span>Return History</span></a></li>
                    </ul>
                </div>
            </li>
            <li><a href="readerChangeInformation.jsp"> Change information</a></li>
            <li><a href="#" onclick="logout();">Logout</a> </li>
        </ul>
    </div>
    	<script>
	function logout() {
		var result = confirm("Please make sure to logout!");
		if (result == true) {
			window.location.href = "DestorySession";
		} else {

		}
	}
</script>