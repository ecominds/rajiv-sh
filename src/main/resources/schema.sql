CREATE TABLE master_project_info (
	record_id int IDENTITY(1,1) PRIMARY KEY,
    project_name nvarchar(128) NOT NULL,
    project_title nvarchar(256) NOT NULL,
    short_desc nvarchar(max) NOT NULL,
    long_desc nvarchar(max) NOT NULL,
    img_url_path varchar(2048) NOT NULL,
    project_initiator nvarchar(128) NOT NULL,
    target_amt float NOT NULL DEFAULT 0,
	start_date date NOT NULL,
	expected_closure_date date NOT NULL,
	completion_stage_id int NOT NULL default 1,
	is_active bit NOT NULL default 1,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE master_user_role (
	record_id int IDENTITY(1,1) PRIMARY KEY,
    role_name nvarchar(64) NOT NULL,
    is_active bit NOT NULL default 1,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE master_user_info (
	record_id int IDENTITY(1,1) PRIMARY KEY,
    first_name nvarchar(64) NOT NULL,
    last_name nvarchar(64) DEFAULT NULL,
    email_add nvarchar(256) DEFAULT NULL,
    user_role_id int NOT NULL default 1,
    auth_source nvarchar(64) DEFAULT NULL,
    is_logged_in bit NOT NULL default 0,
    user_status_id int NOT NULL default 1,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE txn_project_ledger(
	record_id int IDENTITY(1,1) PRIMARY KEY,
    user_ref_id int NOT NULL,
    project_ref_id int NOT NULL,
    txn_amt float NOT NULL DEFAULT 0,
    txn_date date NOT NULL,
    txn_status int NOT NULL default 1,
    txn_resp_desc nvarchar(max) DEFAULT NULL,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE txn_project_spent(
	record_id int IDENTITY(1,1) PRIMARY KEY,
    project_ref_id int NOT NULL,
    txn_amt float NOT NULL DEFAULT 0,
    txn_date date NOT NULL,
    txn_desc nvarchar(max) DEFAULT NULL,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE social_user_info (
	record_id int IDENTITY(1,1) PRIMARY KEY,
    
	first_name nvarchar(64) NOT NULL,
    last_name nvarchar(64) DEFAULT NULL,
    email_add nvarchar(256) DEFAULT NULL,
	
	gender nvarchar(1) DEFAULT NULL,
	locale nvarchar(16) DEFAULT NULL,
	img_url_path nvarchar(512) DEFAULT NULL,
	
    user_role_id int NOT NULL default 1,
	
    oauth_provider nvarchar(16) DEFAULT NULL,
	oauth_uid nvarchar(128) DEFAULT NULL,
	url_path nvarchar(512) DEFAULT NULL,
	
    is_logged_in bit NOT NULL default 0,
    user_status_id int NOT NULL default 1,
	created_at DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP()),
	modified_at DATETIME DEFAULT NULL 
);

CREATE TABLE master_site_settings (
	record_id int IDENTITY(1, 1) PRIMARY KEY,
	key_to_access varchar(32) NOT NULL,
    title nvarchar(64) NOT NULL,
    short_desc nvarchar(128) DEFAULT NULL,
    popup_index int NOT NULL default 1,
    is_checked bit NOT NULL default 0,
    is_active bit NOT NULL default 1,
	created_date DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP())
);

CREATE TABLE master_team_member (
	record_id int IDENTITY(1,1) PRIMARY KEY,
    
	first_name nvarchar(64) NOT NULL,
    last_name nvarchar(64) DEFAULT NULL,
    email_add nvarchar(256) DEFAULT NULL,
	address nvarchar(256) DEFAULT NULL,
	contact_no nvarchar(32) DEFAULT NULL,
	
	gender nvarchar(1) DEFAULT NULL,

	img_url_path nvarchar(512) DEFAULT NULL,
	
    user_role_id int NOT NULL default 1,
	about_me nvarchar(512) DEFAULT NULL,
	
    is_logged_in bit NOT NULL default 0,
    status_id int NOT NULL default 1,
	created_at DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP()),
	modified_at DATETIME DEFAULT NULL 
);