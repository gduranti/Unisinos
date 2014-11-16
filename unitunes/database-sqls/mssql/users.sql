USE [unitunes]
GO

/****** Object:  Table [dbo].[USERS]    Script Date: 11/16/2014 20:09:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[USERS](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[type] [int] NOT NULL,
	[status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[USERS] ADD  DEFAULT ((0)) FOR [status]
GO
