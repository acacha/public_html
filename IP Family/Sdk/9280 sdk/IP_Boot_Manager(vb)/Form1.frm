VERSION 5.00
Object = "{126E8F99-2B6E-4396-A052-4BD16B40485E}#1.0#0"; "IPEdit.ocx"
Object = "{248DD890-BB45-11CF-9ABC-0080C7E7B78D}#1.0#0"; "MSWINSCK.OCX"
Begin VB.Form P 
   AutoRedraw      =   -1  'True
   Caption         =   "IP Control 9280"
   ClientHeight    =   5595
   ClientLeft      =   165
   ClientTop       =   555
   ClientWidth     =   9225
   Icon            =   "Form1.frx":0000
   LinkTopic       =   "Form1"
   ScaleHeight     =   5595
   ScaleWidth      =   9225
   StartUpPosition =   3  'Windows Default
   Begin MSWinsockLib.Winsock Winsock1 
      Left            =   2160
      Top             =   5280
      _ExtentX        =   741
      _ExtentY        =   741
      _Version        =   393216
   End
   Begin VB.CommandButton C_Refresh 
      Caption         =   "Refresh"
      Height          =   435
      Left            =   2520
      TabIndex        =   77
      Top             =   5040
      Width           =   1095
   End
   Begin IPEdit.Search_92xx Search_92xx1 
      Height          =   1335
      Left            =   0
      TabIndex        =   76
      Top             =   3720
      Width           =   3735
      _ExtentX        =   6588
      _ExtentY        =   2355
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
   End
   Begin VB.PictureBox Login 
      Appearance      =   0  'Flat
      BorderStyle     =   0  'None
      ForeColor       =   &H80000008&
      Height          =   3375
      Left            =   0
      Picture         =   "Form1.frx":0442
      ScaleHeight     =   3375
      ScaleWidth      =   9135
      TabIndex        =   64
      Top             =   0
      Width           =   9135
      Begin VB.Timer Timer2 
         Left            =   2880
         Top             =   2880
      End
   End
   Begin VB.PictureBox Logout 
      Appearance      =   0  'Flat
      BorderStyle     =   0  'None
      ForeColor       =   &H80000008&
      Height          =   3375
      Left            =   0
      Picture         =   "Form1.frx":76702
      ScaleHeight     =   3375
      ScaleWidth      =   9135
      TabIndex        =   55
      Top             =   0
      Width           =   9135
   End
   Begin VB.Frame Frame9 
      Caption         =   "Connect"
      Height          =   1815
      Left            =   3840
      TabIndex        =   49
      Top             =   3720
      Width           =   5295
      Begin VB.CommandButton C_OutControl 
         Caption         =   "Out Control"
         Enabled         =   0   'False
         Height          =   375
         Left            =   3960
         TabIndex        =   78
         Top             =   1200
         Width           =   1215
      End
      Begin VB.TextBox Sec 
         Height          =   375
         Left            =   2640
         TabIndex        =   65
         Text            =   "10"
         Top             =   1200
         Width           =   1095
      End
      Begin VB.CommandButton Command1 
         Caption         =   "Transimt"
         Height          =   375
         Left            =   3960
         MouseIcon       =   "Form1.frx":106BC6
         MousePointer    =   99  'Custom
         TabIndex        =   52
         Top             =   720
         Width           =   1215
      End
      Begin VB.TextBox Text2 
         Height          =   375
         IMEMode         =   3  'DISABLE
         Left            =   2160
         PasswordChar    =   "*"
         TabIndex        =   51
         Text            =   "12345678"
         Top             =   720
         Width           =   1575
      End
      Begin VB.TextBox Text1 
         Height          =   375
         Left            =   2160
         TabIndex        =   50
         Text            =   "192.168.1.100"
         Top             =   240
         Width           =   1575
      End
      Begin VB.Label Label1 
         AutoSize        =   -1  'True
         Caption         =   "each second to read power state:"
         Height          =   435
         Left            =   120
         TabIndex        =   66
         Top             =   1320
         Width           =   2505
      End
      Begin VB.Label Label9 
         AutoSize        =   -1  'True
         Caption         =   "Input IP Address :"
         Height          =   195
         Left            =   240
         TabIndex        =   54
         Top             =   360
         Width           =   1260
      End
      Begin VB.Label Label10 
         AutoSize        =   -1  'True
         Caption         =   "Input Password(Max = 8) :"
         Height          =   195
         Left            =   240
         TabIndex        =   53
         Top             =   840
         Width           =   1845
      End
   End
   Begin VB.PictureBox Picture4 
      Appearance      =   0  'Flat
      BackColor       =   &H80000005&
      BorderStyle     =   0  'None
      ForeColor       =   &H80000008&
      Height          =   1215
      Left            =   360
      Picture         =   "Form1.frx":107008
      ScaleHeight     =   1215
      ScaleMode       =   0  'User
      ScaleWidth      =   3472.347
      TabIndex        =   13
      Top             =   3840
      Width           =   2990
   End
   Begin VB.Frame Frame8 
      Height          =   1575
      Left            =   6960
      TabIndex        =   12
      Top             =   1800
      Width           =   2175
      Begin VB.TextBox P8_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   63
         Text            =   "Power8"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P8_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":1179EC
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   48
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P8_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":11ADD8
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":11B21A
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   47
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P8_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":11BDC2
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":11C204
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   46
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P8_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":11D0D0
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":11D512
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   45
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P8_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":11E3DE
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   44
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture8 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":1217CA
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   74
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame7 
      Height          =   1575
      Left            =   4680
      TabIndex        =   11
      Top             =   1800
      Width           =   2175
      Begin VB.TextBox P7_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   62
         Text            =   "Power7"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P7_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":1247A2
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   43
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P7_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":127B8E
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":127FD0
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   42
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P7_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":128B78
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":128FBA
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   41
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P7_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":129E86
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":12A2C8
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   40
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P7_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":12B194
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   39
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture7 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":12E580
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   73
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame6 
      Height          =   1575
      Left            =   2400
      TabIndex        =   10
      Top             =   1800
      Width           =   2175
      Begin VB.TextBox P6_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   61
         Text            =   "Power6"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P6_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":131558
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   38
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P6_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":134944
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":134D86
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   37
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P6_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":13592E
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":135D70
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   36
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P6_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":136C3C
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":13707E
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   35
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P6_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":137F4A
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   34
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture6 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":13B336
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   72
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame5 
      Height          =   1575
      Left            =   120
      TabIndex        =   9
      Top             =   1800
      Width           =   2175
      Begin VB.TextBox P5_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   60
         Text            =   "Power5"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P5_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":13E30E
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   33
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P5_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1480
         MouseIcon       =   "Form1.frx":1416FA
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":141B3C
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   32
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P5_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1480
         MouseIcon       =   "Form1.frx":1426E4
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":142B26
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   31
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P5_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1480
         MouseIcon       =   "Form1.frx":1439F2
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":143E34
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   30
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P5_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":144D00
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   29
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture5 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1440
         Picture         =   "Form1.frx":1480EC
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   71
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame4 
      Height          =   1575
      Left            =   6960
      TabIndex        =   8
      Top             =   120
      Width           =   2175
      Begin VB.TextBox P4_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   59
         Text            =   "Power4"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P4_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":14B0C4
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   28
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P4_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":14E4B0
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":14E8F2
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   27
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P4_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":14F49A
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":14F8DC
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   26
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P4_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":1507A8
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":150BEA
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   25
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P4_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":151AB6
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   24
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture3 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":154EA2
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   70
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame3 
      Height          =   1575
      Left            =   4680
      TabIndex        =   7
      Top             =   120
      Width           =   2175
      Begin VB.TextBox P3_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   58
         Text            =   "Power3"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P3_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":157E7A
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   23
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P3_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":15B266
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":15B6A8
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   22
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P3_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":15C250
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":15C692
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   21
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P3_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":15D55E
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":15D9A0
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   20
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P3_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":15E86C
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   19
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture2 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":161C58
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   69
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame2 
      Height          =   1575
      Left            =   2400
      TabIndex        =   6
      Top             =   120
      Width           =   2175
      Begin VB.TextBox P2_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   57
         Text            =   "Power2"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P2_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":164C30
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   18
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P2_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":16801C
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":16845E
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   17
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P2_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":169006
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":169448
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   16
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P2_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1380
         MouseIcon       =   "Form1.frx":16A314
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":16A756
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   15
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P2_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":16B622
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   14
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture1 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1320
         Picture         =   "Form1.frx":16EA0E
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   68
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Frame Frame1 
      Height          =   1575
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   2175
      Begin VB.TextBox P1_L 
         Appearance      =   0  'Flat
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   13.5
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   120
         TabIndex        =   56
         Text            =   "Power1"
         Top             =   1080
         Width           =   1095
      End
      Begin VB.PictureBox P1_P_D 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":1719E6
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   5
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox P1_C_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1500
         MouseIcon       =   "Form1.frx":174DD2
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":175214
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   4
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P1_C_R 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1500
         MouseIcon       =   "Form1.frx":1760E0
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":176522
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   3
         Top             =   960
         Width           =   400
      End
      Begin VB.PictureBox P1_C_G 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   400
         Left            =   1500
         MouseIcon       =   "Form1.frx":1773EE
         MousePointer    =   99  'Custom
         Picture         =   "Form1.frx":177830
         ScaleHeight     =   405
         ScaleMode       =   0  'User
         ScaleWidth      =   471.123
         TabIndex        =   2
         Top             =   360
         Width           =   400
      End
      Begin VB.PictureBox P1_P_B 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   855
         Left            =   360
         Picture         =   "Form1.frx":1783D8
         ScaleHeight     =   855
         ScaleMode       =   0  'User
         ScaleWidth      =   994.592
         TabIndex        =   1
         Top             =   240
         Width           =   855
      End
      Begin VB.PictureBox Picture25 
         Appearance      =   0  'Flat
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         ForeColor       =   &H80000008&
         Height          =   1300
         Left            =   1440
         Picture         =   "Form1.frx":17B7C4
         ScaleHeight     =   1318.385
         ScaleMode       =   0  'User
         ScaleWidth      =   610.714
         TabIndex        =   67
         Top             =   120
         Width           =   520
      End
   End
   Begin VB.Timer Timer1 
      Enabled         =   0   'False
      Interval        =   1
      Left            =   2400
      Top             =   3600
   End
   Begin VB.Label Label2 
      Caption         =   "last time :"
      Height          =   375
      Left            =   0
      TabIndex        =   75
      Top             =   5160
      Visible         =   0   'False
      Width           =   1695
   End
End
Attribute VB_Name = "P"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'
'Cancel LockText
'2008.0328 Cloud
Dim ipaddress, password, connect, Second
Dim TargetSecond
Dim before_time, after_time, During_time

Private Sub Gray_Status()
    Logout.Visible = True
    Search_92xx1.Visible = True
    C_Refresh.Visible = True
        
    
End Sub
Private Sub GetPower_Status()
Dim j, k

'On Error GoTo ErrorHandler
ipaddress = Text1.Text
'password = ""
Logout.Visible = False
Login.Visible = True

'If Text2.Text = "" Then
'    password = ""
'    Call Gray_Status
'Else
    If Text2.Text <> "" Then
    
        password = Text2.Text
    Else
        password = ""
    End If
    
'    j = "http://admin:" & password & "@" & ipaddress & "/Set.cmd?CMD=GetPower"
'   j = "http://" & ipaddress & "/Set.cmd?CMD=GetPower"
    j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=GetPower"

    k = GeturlPowerStatus(j, password, 0)
    

    If (k = -1) Or (k >= 261) Or (k = Null) Or (k < 0) Then
                MsgBox ("Wrong IP or Passowrd ")
                Text2.Text = ""
                Logout.Visible = True
                Timer1.Enabled = False
                Search_92xx1.Visible = True
                Login.Visible() = True


                C_Refresh.Visible = True

       ' connect = 0
    Else
      '  Text1.Locked = True
       ' Text2.Locked = True
       ' connect = 1
        If (k And 1) Then
            P1_P_B.Visible = True
            P1_P_D.Visible = False
            P1_C_B.Visible = False
            P1_C_R.Visible = True
        Else
            P1_P_B.Visible = False
            P1_P_D.Visible = True
            P1_C_B.Visible = True
            P1_C_R.Visible = False
        End If
            
        If (k And 2) Then
            P2_P_B.Visible = True
            P2_P_D.Visible = False
            P2_C_B.Visible = False
            P2_C_R.Visible = True
        Else
            P2_P_B.Visible = False
            P2_P_D.Visible = True
            P2_C_B.Visible = True
            P2_C_R.Visible = False
        End If
        
        If (k And 4) Then
            P3_P_B.Visible = True
            P3_P_D.Visible = False
            P3_C_B.Visible = False
            P3_C_R.Visible = True
        Else
            P3_P_B.Visible = False
            P3_P_D.Visible = True
            P3_C_B.Visible = True
            P3_C_R.Visible = False
        End If
        
        
        If (k And 8) Then
            P4_P_B.Visible = True
            P4_P_D.Visible = False
            P4_C_B.Visible = False
            P4_C_R.Visible = True
        Else
            P4_P_B.Visible = False
            P4_P_D.Visible = True
            P4_C_B.Visible = True
            P4_C_R.Visible = False
        End If
        
        If (k And 16) Then
            P5_P_B.Visible = True
            P5_P_D.Visible = False
            P5_C_B.Visible = False
            P5_C_R.Visible = True
        Else
            P5_P_B.Visible = False
            P5_P_D.Visible = True
            P5_C_B.Visible = True
            P5_C_R.Visible = False
        End If
        
        
        If (k And 32) Then
            P6_P_B.Visible = True
            P6_P_D.Visible = False
            P6_C_B.Visible = False
            P6_C_R.Visible = True
        Else
            P6_P_B.Visible = False
            P6_P_D.Visible = True
            P6_C_B.Visible = True
            P6_C_R.Visible = False
        End If
        
        If (k And 64) Then
            P7_P_B.Visible = True
            P7_P_D.Visible = False
            P7_C_B.Visible = False
            P7_C_R.Visible = True
        Else
            P7_P_B.Visible = False
            P7_P_D.Visible = True
            P7_C_B.Visible = True
            P7_C_R.Visible = False
        End If
        
        If (k And 128) Then
            P8_P_B.Visible = True
            P8_P_D.Visible = False
            P8_C_B.Visible = False
            P8_C_R.Visible = True
        Else
            P8_P_B.Visible = False
            P8_P_D.Visible = True
            P8_C_B.Visible = True
            P8_C_R.Visible = False
        End If
        'Command1.Caption = "UnLock"
        
    End If
    Login.Visible = False

    
'End If
    
    Exit Sub
ErrorHandler:
    MsgBox ("Error")
    Timer1.Enabled = False
    Logout.Visible = True
    Login.Visible = False
End Sub

Private Sub Socket_Close()
Search_92xx1.My_Socket_Close = True
End Sub

Private Sub C_OutControl_Click()
        Timer1.Enabled = False
        Search_92xx1.Visible = True
        Logout.Visible = True
        C_Refresh.Visible = True
        C_OutControl.Enabled = False
        Command1.Enabled = True

        Text1.Enabled = True

        Text2.Enabled = True



End Sub

Private Sub C_Refresh_Click()
Call Socket_Close
Search_92xx1.Refresh
Timer2.Enabled = True



End Sub

Private Sub Command1_Click()
    
On Error GoTo ErrorHandler
    
    If Text1.Text = "" Then
            'UPGRADE_WARNING: 無法解析物件 password 的預設屬性。 按一下以取得詳細資訊: 'ms-help://MS.VSCC.2003/commoner/redir/redirect.htm?keyword="vbup1037"'
            password = ""
            MsgBox ("Wrong IP")
            Timer1.Enabled = False

            Call Gray_Status
    Else
        'MsgBox (IsEmpty(Sec.Text))
        If (Int(Sec.Text) < 5) Then
                
            Sec.Text = 5
       
        End If
        TargetSecond = Timer() + Sec.Text
        'MsgBox ("GetPowerStatus")
        Call GetPower_Status
        
        'close socket
        Call Socket_Close
        Search_92xx1.Visible = False
        C_Refresh.Visible = False
        
        before_time = Int(Format(Time, "ss"))
        after_time = Int(Format(Time, "ss"))
        During_time = Sec.Text
        
        'Button
            C_OutControl.Enabled = True
            Command1.Enabled = False
            Text1.Enabled = False
            Text2.Enabled = False
            Search_92xx1.My_Socket_Close() = True

        
        Timer1.Enabled = True
    End If
    
    Exit Sub
ErrorHandler:
    MsgBox ("Please Input")
    Timer1.Enabled = False


End Sub




Private Sub Command2_Click()

End Sub

Private Sub Form_Unload(Cancel As Integer)
Dim cpath As String
  cAppPath = App.Path & "\"
Dim f1 As Long

f1 = FreeFile
Open cpath & "rec.ini" For Output As #f1
Write #f1, P1_L.Text, P2_L.Text, P3_L.Text, P4_L.Text, P5_L.Text, P6_L.Text, P7_L.Text, P8_L.Text, Text1.Text, Text2.Text


Close f1


End Sub

Private Sub P1_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P1=0"
'j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=GetPower"

k = Posturl(j, password)

End Sub
Private Sub P1_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P1=1"
k = Posturl(j, password)

End Sub
Private Sub P1_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P1=1"
k = Posturl(j, password)

End Sub




Private Sub P2_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P2=0"
k = Posturl(j, password)

End Sub
Private Sub P2_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P2=1"
k = Posturl(j, password)

End Sub
Private Sub P2_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P2=1"
k = Posturl(j, password)

End Sub


Private Sub P3_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P3=0"
k = Posturl(j, password)

End Sub
Private Sub P3_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P3=1"
k = Posturl(j, password)

End Sub
Private Sub P3_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P3=1"
k = Posturl(j, password)

End Sub

Private Sub P4_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P4=0"
k = Posturl(j, password)

End Sub
Private Sub P4_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P4=1"
k = Posturl(j, password)

End Sub
Private Sub P4_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P4=1"
k = Posturl(j, password)

End Sub

Private Sub P5_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P5=0"
k = Posturl(j, password)

End Sub
Private Sub P5_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P5=1"
k = Posturl(j, password)

End Sub
Private Sub P5_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P5=1"
k = Posturl(j, password)

End Sub

Private Sub P6_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P6=0"
k = Posturl(j, password)

End Sub
Private Sub P6_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P6=1"
k = Posturl(j, password)

End Sub
Private Sub P6_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P6=1"
k = Posturl(j, password)

End Sub

Private Sub P7_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P7=0"
k = Posturl(j, password)

End Sub
Private Sub P7_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P7=1"
k = Posturl(j, password)

End Sub
Private Sub P7_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P7=1"
k = Posturl(j, password)

End Sub
Private Sub P8_C_G_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P8=0"
k = Posturl(j, password)

End Sub
Private Sub P8_C_B_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P8=1"
k = Posturl(j, password)

End Sub
Private Sub P8_C_R_click()
Dim j, k
j = "http://" & ipaddress & "/Set.cmd?user=admin+pass=" & password & "CMD=SetPower+P8=1"
k = Posturl(j, password)

End Sub
Private Sub Form_Load()
Sec = 0
Login.Visible = False

Timer1.Enabled = False
Timer2.Enabled = True
Timer2.Interval = 100

Search_92xx1.Refresh



Sec.Text = 10



  Dim nFn1 As Long
  Dim ctmpStr
  Dim cAppPath
  cAppPath = App.Path & "\"
  
    nFn1 = FreeFile
    Open cAppPath & "rec.ini" For Input As #nFn1
    
    Input #nFn1, ctmpStr
    'MsgBox (ctmpStr)
    P1_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P2_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P3_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P4_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P5_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P6_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P7_L.Text = ctmpStr
    Input #nFn1, ctmpStr
    P8_L.Text = ctmpStr
    
    'Input #nFn1, ctmpStr
    'Text1.Text = ctmpStr
    
    'Input #nFn1, ctmpStr
    'Text2.Text = ctmpStr
    
    Close nFn1



End Sub


Private Sub Timer1_Timer()
'If (Sec.Text < 5) Then
'Sec.Text = 5
'End If
'Second = Timer()
'If (Second = TargetSecond) Then
'    TargetSecond = TargetSecond + Sec.Text
time1 = after_time - before_time
If time1 < 0 Then
   time1 = time1 + 60
End If
Label2.Caption = "last time :" & time1 & " sec"
If time1 = Int(During_time) Then
    before_time = Int(Format(Time, "ss"))
    after_time = Int(Format(Time, "ss"))
    Call GetPower_Status
Else
    after_time = Int(Format(Time, "ss"))
End If
End Sub


    

Private Sub Timer2_Timer()

If Search_92xx1.My_IPAddress <> "" Then
    'Timer2.Enabled = False
    
    Text1.Text = Search_92xx1.My_IPAddress & ":" & Search_92xx1.My_Port
    Call Socket_Close
    
End If



'If (Search_92xx1.My_Click = True) Then
'    If Search_92xx1.My_Click = True Then
'        Label_Select_92xx.Caption = " Click : " & Search_92xx1.My_ProductName & " --> " & Search_92xx1.My_IPAddress & " : " & Search_92xx1.My_Port
'    End If
'Else

End Sub
