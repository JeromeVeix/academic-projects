import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime
from scipy.stats import norm

# pd.options.display.max_columns = 100
pd.set_option("display.precision", 4)
pd.options.display.float_format = '{:.2f}'.format

Merged = pd.read_csv("m3")
Merged.info()
Merged.describe(include = 'all')

multilevel =pd.crosstab(index=[Merged.FIRST_TIME_HOME_BUYER,Merged.BORROWER_GENDER,Merged.BORROWER_AGE], columns=Merged.BORROWER_RACE_NATIONALORIG19)
multilevel[:5]

multilevel1 =pd.crosstab(index=[Merged.FIRST_TIME_HOME_BUYER,Merged.BORROWER_GENDER,Merged.BORROWER_AGE], columns=Merged.BORROWER_RACE_NATIONALORIG20)
multilevel1[:5]

multilevel2 =pd.crosstab(index=[Merged.FIRST_TIME_HOME_BUYER,Merged.BORROWER_GENDER,Merged.BORROWER_AGE], columns=Merged.BORROWER_RACE_NATIONALORIG21)
multilevel2[:5]

multilevel3 =pd.crosstab(index=[Merged.FIRST_TIME_HOME_BUYER,Merged.BORROWER_GENDER,Merged.BORROWER_AGE], columns=Merged.BORROWER_RACE_NATIONALORIG22)
multilevel3[:5]

multilevel4 =pd.crosstab(index=[Merged.FIRST_TIME_HOME_BUYER,Merged.BORROWER_GENDER,Merged.BORROWER_AGE], columns=Merged.BORROWER_RACE_NATIONALORIG23)
multilevel4[:5]

multilevel3 =pd.crosstab(index=[Merged.BORROWER_RACE_NATIONALORIG21,Merged.BORROWER_AGE], columns=Merged.FIRST_TIME_HOME_BUYER)
multilevel3
#This automicatilly rejects our null hypothesis as it shows how most of the homeowners are non-first time homebuyers

import ptitprince as pt

f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_AGE', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)
                  
f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_RACE_NATIONALORIG19', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)
                  
f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_RACE_NATIONALORIG20', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)

f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_RACE_NATIONALORIG21', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)
                  
f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_RACE_NATIONALORIG22', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)      
                  
f, ax = plt.subplots(figsize=(12, 10))
sns.set(style="whitegrid",font_scale=2)
ax = pt.RainCloud(x = 'BORROWER_RACE_NATIONALORIG23', y = 'FIRST_TIME_HOME_BUYER', 
                  data = Merged, 
                  width_viol = .8,
                  width_box = .4,
                  orient= 'h',
                  move = .0)                              