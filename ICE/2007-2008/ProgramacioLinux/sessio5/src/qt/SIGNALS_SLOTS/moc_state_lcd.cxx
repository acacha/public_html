/****************************************************************************
** StateLCDWidget meta object code from reading C++ file 'state_lcd.hxx'
**
** Created: Thu Feb 4 21:00:17 1999
**      by: The Qt Meta Object Compiler ($Revision: 2.25.2.11 $)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#if !defined(Q_MOC_OUTPUT_REVISION)
#define Q_MOC_OUTPUT_REVISION 2
#elif Q_MOC_OUTPUT_REVISION != 2
#error "Moc format conflict - please regenerate all moc files"
#endif

#include "state_lcd.hxx"
#include <qmetaobject.h>


const char *StateLCDWidget::className() const
{
    return "StateLCDWidget";
}

QMetaObject *StateLCDWidget::metaObj = 0;


#if QT_VERSION >= 200
static QMetaObjectInit init_StateLCDWidget(&StateLCDWidget::staticMetaObject);

#endif

void StateLCDWidget::initMetaObject()
{
    if ( metaObj )
	return;
    if ( strcmp(QWidget::className(), "QWidget") != 0 )
	badSuperclassWarning("StateLCDWidget","QWidget");

#if QT_VERSION >= 200
    staticMetaObject();
}

void StateLCDWidget::staticMetaObject()
{
    if ( metaObj )
	return;
    QWidget::staticMetaObject();
#else

    QWidget::initMetaObject();
#endif

    typedef void(StateLCDWidget::*m1_t0)();
    typedef void(StateLCDWidget::*m1_t1)();
    m1_t0 v1_0 = &StateLCDWidget::increaseValue;
    m1_t1 v1_1 = &StateLCDWidget::decreaseValue;
    QMetaData *slot_tbl = new QMetaData[2];
    slot_tbl[0].name = "increaseValue()";
    slot_tbl[1].name = "decreaseValue()";
    slot_tbl[0].ptr = *((QMember*)&v1_0);
    slot_tbl[1].ptr = *((QMember*)&v1_1);
    metaObj = new QMetaObject( "StateLCDWidget", "QWidget",
	slot_tbl, 2,
	0, 0 );
}
